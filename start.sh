#!/bin/bash

terminate_processes() {
  echo "Terminating processes..."
  kill $(jobs -p)
  exit
}

# CTRL+C sinyalini yakala
trap 'terminate_processes' SIGINT



# Backend start
cd generator && ./gradlew bootRun &

cd validator && ./gradlew bootRun &



# Frontend start
cd frontend && npm start 

