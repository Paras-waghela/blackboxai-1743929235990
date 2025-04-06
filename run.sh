#!/bin/bash
# Hospital Management System Startup Script

# Cleanup previous processes
pkill -f rmiregistry
pkill -f java
pkill -f python3

# Create required directories
mkdir -p patient_files