#Step 1 : Install Node.js

Download Node.js from https://nodejs.org/en/
Please download LTS version.

#Step 2 : Configure http proxy (if required)

npm config set https-proxy http://<user_name>:<user_password>@172.16.106.32:80/
npm config set proxy http://<user_name>:<user_password>@172.16.106.32:80/

<-- dsat proxy

#Step 3 : Add Environment Variable

Append C:\Users\<user_name>\AppData\Roaming\npm  to end of %PATH%

#Step 4 : Initialize npm module (run once @ each workstation)

npm init -y

#Step 5 : Global install required package in workstation (run once @ each workstation)

npm install gulp-cli -g
npm install gulp -g
npm install gulp-rev -g
npm install gulp-rev-collector -g
npm install del -g 
npm link gulp 
npm link gulp-rev 
npm link gulp-rev-collector 
npm link del 

#Step 6 : Update JS reference in html

gulp