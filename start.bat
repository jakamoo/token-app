@echo off
SETLOCAL ENABLEDELAYEDEXPANSION

:: Define Ctrl+C trap
echo Press Ctrl+C to stop all processes...

:: Start Frontend
cd token-manager-app
npm install
start npm start
echo Frontend is starting...

:: Start Backend
cd ..\backend\tokenManager
call gradlew bootRun
echo Backend (Token Manager) is starting...

:: Keep the batch file running
pause
