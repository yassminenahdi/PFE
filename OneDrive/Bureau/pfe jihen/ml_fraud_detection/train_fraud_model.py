import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
import pickle

# Load sample data from CSV (replace with real export if available)
df = pd.read_csv('wallet_operations_sample.csv')

# Convert categorical features to numeric using one-hot encoding
df = pd.get_dummies(df, columns=['currency', 'status', 'wallet_type', 'operation_type'])

# Features and label
y = df['is_fraud']
X = df.drop(['is_fraud', 'label', 'timestamp'], axis=1)  # Drop non-numeric/non-useful columns

# Train model
model = RandomForestClassifier(n_estimators=100, random_state=42)
model.fit(X, y)

# Save the model and feature columns
with open('fraud_model.pkl', 'wb') as f:
    pickle.dump({'model': model, 'columns': X.columns.tolist()}, f)

print('Model trained on wallet operations and saved as fraud_model.pkl')
