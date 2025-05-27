# Vehicle Data Integration Service

This Spring Boot project integrates with a third-party vehicle data provider (e.g., CarXE) to deliver comprehensive vehicle reports using VIN (Vehicle Identification Number).

> ⚙️ **Modular architecture** allows easy replacement of the external provider in the future.

---

## 📦 Features

- 🔍 Get complete car information using VIN
- 🖼️ Retrieve vehicle images
- 🏷️ Fetch current market value
- 📄 Obtain vehicle history

---

## 📂 Unified API Endpoint

### `GET /api/v1/car-details/full?vin=YOUR_VIN`

**Description:**  
Returns **full vehicle details** in a single response, including metadata, images, market value, and history.

#### ✅ Request Parameter

| Param | Description                   | Required |
| ----- | ----------------------------- | -------- |
| `vin` | Vehicle Identification Number | Yes      |

---

### ✅ Sample Response

```json
{
  "vin": "1HGCM82633A004352",
  "make": "Honda",
  "model": "Accord",
  "year": 2015,
  "trim": "EX-L",
  "engine": "2.4L I4",
  "marketValue": "$10,500",
  "history": "2 accidents, 1 owner, regular maintenance reported",
  "images": [
    {
      "url": "https://cdn.example.com/images/car_front.jpg",
      "angle": "front"
    },
    {
      "url": "https://cdn.example.com/images/car_rear.jpg",
      "angle": "rear"
    }
  ]
}
```
