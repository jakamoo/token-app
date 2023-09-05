# Token Manager

## Overview
Token Manager is a web-based application that allows users to generate random tokens using specific numbers and to validate those tokens.

## Features
- Token Format: XXXX-XXXX-XXXX-XXXX
- Allows users to select available numbers for token generation via the UI.
- Uses backend services for token generation and validation processes.
- Token validation is performed using the Luhn algorithm.

## Technology Stack
- **Frontend**: React
- **Backend Services**: Spring Boot (GeneratorService and ValidatorService)
- **Communication**: REST API

## Project Structure
- /token-manager-app - React-based frontend codes
- /backend - Codes for GeneratorService and ValidatorService
- start.sh - Script to start all services
- start.bat - Start script for Windows

## How to Run
1. Clone the project:
git clone https://github.com/jakamoo/tokenManager.git
cd tokenManager


2. To start the services and frontend application:
./start.sh


or for Windows:
start.bat



## Access
The frontend application will be running at `localhost:8080`.

