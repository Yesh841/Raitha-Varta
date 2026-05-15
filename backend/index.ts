import express from "express";
import cors from "cors";
import dotenv from "dotenv";
import { GoogleGenAI } from "@google/genai";

dotenv.config();

const app = express();
const PORT = process.env.PORT || 3000;

app.use(cors());
app.use(express.json({ limit: '10mb' }));

app.get("/", (req, res) => {
  res.send(`
    <html>
      <body style="font-family: 'Helvetica Neue', Arial, sans-serif; padding: 2rem; background: #F1F8E9; color: #1B5E20; display: flex; flex-direction: column; align-items: center; justify-content: center; min-height: 100vh; text-align: center;">
        <div style="background: white; border: 2px solid #C8E6C9; padding: 3rem; border-radius: 36px; box-shadow: 0 30px 60px rgba(0,0,0,0.05); max-width: 500px;">
          <h1 style="font-size: 3rem; margin: 0; font-weight: 900; letter-spacing: -2px;">Raitha-Varta</h1>
          <p style="font-weight: 700; margin-top: 5px; opacity: 0.8;">Farmer's Voice • ರೈತರ ಧ್ವನಿ</p>
          
          <div style="background: #FFD54F; padding: 1rem; border-radius: 20px; margin: 2rem 0; color: #000;">
            <p style="margin: 0; font-weight: 800; font-size: 1.2rem;">API Backend Online</p>
            <p style="margin: 0; opacity: 0.7;">Ready to generate AI Tips & Detect Pests</p>
          </div>

          <div style="text-align: left; background: #E8F5E9; padding: 1.5rem; border-radius: 24px;">
            <h3 style="margin-top: 0;">Available Endpoints:</h3>
            <ul style="list-style: none; padding: 0;">
              <li style="padding: 5px 0;">🟢 <b>POST</b> /api/tips/generate</li>
              <li style="padding: 5px 0;">🟢 <b>POST</b> /api/disease/detect</li>
              <li style="padding: 5px 0;">🟢 <b>GET</b> /api/weather/:lat/:lng</li>
            </ul>
          </div>
        </div>
      </body>
    </html>
  `);
});

const ai = new GoogleGenAI({ apiKey: process.env.GEMINI_API_KEY || "" });

// --- API ENDPOINTS ---

// 1. Tip Generation (Agricultural Advisory)
app.post("/api/tips/generate", async (req, res) => {
  const { cropName, language } = req.body;
  if (!cropName) return res.status(400).json({ error: "cropName is required" });

  try {
    const response = await ai.models.generateContent({
      model: "gemini-3-flash-preview",
      contents: `Generate a 1-minute actionable farming tip for ${cropName} in ${language || 'English'}. 
      Format it as a JSON object with fields: title, description, imageUrl (placeholder).
      Keep it very practical for a small-scale farmer.`,
      config: { responseMimeType: "application/json" }
    });
    
    res.json(JSON.parse(response.text));
  } catch (error) {
    res.status(500).json({ error: "Failed to generate tip", details: String(error) });
  }
});

// 2. Disease Detection
app.post("/api/disease/detect", async (req, res) => {
  const { imageBase64 } = req.body;
  if (!imageBase64) return res.status(400).json({ error: "imageBase64 is required" });

  try {
    const response = await ai.models.generateContent({
      model: "gemini-3-flash-preview",
      contents: [
        { text: "Analyze this agricultural leaf photo for diseases. Provide: 1. Disease name, 2. Severity (High/Low), 3. Recommended Treatment in a clear, farmer-friendly style." },
        { inlineData: { data: imageBase64, mimeType: "image/jpeg" } }
      ]
    });
    
    res.json({ analysis: response.text });
  } catch (error) {
    res.status(500).json({ error: "Failed to analyze image", details: String(error) });
  }
});

// 3. Weather Integration (Mocking for now, usually calls OpenWeatherMap)
app.get("/api/weather/:lat/:lng", async (req, res) => {
  const { lat, lng } = req.params;
  // Mocking hyperlocal weather response
  res.json({
    location: `Lat ${lat}, Lng ${lng}`,
    temperature: "28°C",
    condition: "Partly Cloudy",
    humidity: "60%",
    forecast: "Expected light rain in 3 days. Good time for fertilizer application."
  });
});

app.listen(PORT, "0.0.0.0", () => {
  console.log(`Raitha-Varta Backend running on port ${PORT}`);
});
