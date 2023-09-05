
/**
 * Validates if the input string contains only single-digit numbers separated by commas.
 *
 * @param {string} input - The input string to be validated.
 * @returns {boolean} - True if the input is valid, otherwise false.
 */
export const isValidInput = (input) => {
  const regex = /^([0-9](,|$))+$/;
  return input.trim() !== '' && regex.test(input);
};

export const isTokenFormatValid = (token) => {
  const regex = /^\d{4}-\d{4}-\d{4}-\d{4}$/;
  return regex.test(token);
};
