import React, { useState } from 'react';
import axios from 'axios';
import { isValidInput } from './ValidationUtils';  
import CONFIG from '../Config';

function TokenGenerator() {
  const [availableDigitsString, setAvailableDigitsString] = useState('');
  const [token, setToken] = useState(null);
  const [error, setError] = useState(null);



  const handleGenerateToken = async () => {
    if (!isValidInput(availableDigitsString)) {  
      setError('Please enter single-digit numbers separated by commas (e.g., 1,2,3).');
      return;
    }

    const availableDigits = availableDigitsString.split(',').map(num => parseInt(num.trim()));

    try {
      const response = await axios.post(CONFIG.API_ENDPOINTS.generateToken, availableDigits); 

      if (response.data && response.data.token) {
        setToken(response.data.token);
        setError(null);
      } else {
        setError('Unexpected response format from the server.');
      }
    } catch (error) {
      setError(error.message || 'An error occurred while generating the token.');
    }
  };

  return (
    <div>
      <h2>Token Generator</h2>
      <div>
        <label>
          Available Digits (comma separated):
          <input
            type="text"
            value={availableDigitsString}
            onChange={(e) => setAvailableDigitsString(e.target.value)}
          />
        </label>
        <button onClick={handleGenerateToken}>Generate</button>
      </div>
      {token && <div>Generated Token: {token}</div>}
      {error && <div style={{ color: 'red' }}>Error: {error}</div>}
    </div>
  );
}

export default TokenGenerator;