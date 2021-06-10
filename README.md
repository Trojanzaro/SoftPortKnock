# SoftPortKnock
A Software implementation of a port knocking server written in Java and JavaScript using puppeteer 

This project is divided in two parts:
1) The Java SoftPortKnock server
2) The JavaScript Puppeteer Scripts

The Purpose of the JavaScript scripts is to create port fowarding rules using Puppeteer in order to interface through a routers default gateway web interface.
For the purpose of this project I'm using a Tenda-AC10U Wifi Router

The Purpose of the JavaServer is to Create/Read a configuration file containing all the fowarding rules including "ip to foward (usually the ip of the server running the JavaServer)" "port number" "time for the port to be opened in milliseconds"

testingas not been yet successful
