import React, { useState } from 'react';
import './TokenValidator.css';
import axios from 'axios';
import CONFIG from '../Config';
import { isTokenFormatValid } from './ValidationUtils';  



function TokenValidator() {
  const [token, setToken] = useState('');
  const [validationResult, setValidationResult] = useState(null);
  const [formatError, setFormatError] = useState(null);

  
  const handleSubmit = async () => {
    if (!isTokenFormatValid(token)) {
      setFormatError('Token format is incorrect. It should be XXXX-XXXX-XXXX-XXXX.');
      setValidationResult(null);
      return 
    }

    try {
      const response = await axios.post(CONFIG.API_ENDPOINTS.validateToken, { token });
      setValidationResult(response.data.isValid);
      setFormatError(null);
    } catch (error) {
      console.error('Error validating token:', error);
    }
  };

  return (
    <div>
      <h2>Token Validator</h2>
      <div>
        <label>
          Token:
          <input 
            type="text"
            value={token}
            onChange={e => setToken(e.target.value)}
          />
        </label>
      </div>
      <button onClick={handleSubmit}>Validate Token</button>
      {formatError && <p style={{color: 'red'}}>{formatError}</p>}
      {validationResult !== null && <p>{validationResult ? 'Valid Token!' : 'Invalid Token!'}</p>}
    </div>
  );
}

export default TokenValidator;
