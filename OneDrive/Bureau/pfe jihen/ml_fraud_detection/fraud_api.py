from flask import Flask, request, jsonify
import pickle
import numpy as np
import pandas as pd

app = Flask(__name__)

# Load the trained model and feature columns
with open('fraud_model.pkl', 'rb') as f:
    data = pickle.load(f)
    model = data['model']
    columns = data['columns']

@app.route('/predict', methods=['POST'])
def predict():
    data = request.json
    # Example expected input:
    # {"amount": 500, "currency": "TND", "status": "SUCCESS", "wallet_type": "PREPAID", "customer_id": 123, "operation_type": "TRANSFER"}
    df = pd.DataFrame([data])
    # One-hot encode categorical features to match training
    df = pd.get_dummies(df)
    # Add any missing columns (from training) as zeros
    for col in columns:
        if col not in df:
            df[col] = 0
    # Ensure column order
    df = df[columns]
    prediction = model.predict(df)[0]
    return jsonify({'fraud': int(prediction)})

if __name__ == '__main__':
    app.run(port=5000)
