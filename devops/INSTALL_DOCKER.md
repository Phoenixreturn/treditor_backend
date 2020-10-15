sudo docker-compose up -d
sudo lsof -i -P -n | grep 27017
sudo kill -9 process_pid
sudo service docker restart
