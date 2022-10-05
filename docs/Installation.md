# Docker

Download package info
```
sudo apt-get update
```

Upgrade system
```
sudo apt-get upgrade
```

Uninstall old installations
```
sudo apt-get remove docker docker-engine docker.io containerd runc
```

Set up the repository
```
sudo apt-get install ca-certificates curl gnupg lsb-release`
``

Add docker gpg tools
```
sudo mkdir -p /etc/apt/keyrings
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
```

Set up docker repository
```
echo "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
```

Install docker engine
```sudo apt-get update
sudo apt-get install docker-ce docker-ce-cli containerd.io docker-compose-plugin
```


Start docker service
```
sudo service docker start
```

View status:
```
sudo service docker status
--------------------------
 * Docker is running  
```

Create docker group
```
sudo groupadd docker
```

Add user to docker group
```
usermod -a -G docker $USER
```

Run docker example
```
docker run hello-world
```

# Kafka

There's a docker compose file in the root. It starts a Kafka and Zookeper instance inside a docker container. 

It will download the following image:

- Docker: https://registry.hub.docker.com/r/spotify/kafka
- Github: https://github.com/spotify/docker-kafka

```
docker compose up -d
```

```
docker ps -a
------------
CONTAINER ID   IMAGE           COMMAND                  CREATED          STATUS          PORTS                                                                                  NAMES
926d1ccdb30f   spotify/kafka   "bash -c '(sleep 15s…"   19 seconds ago   Up 18 seconds   0.0.0.0:2181->2181/tcp, :::2181->2181/tcp, 0.0.0.0:9092->9092/tcp, :::9092->9092/tcp   kafka
```

# Java
```
sudo apt-get install openjdk-11-jdk
```

# Maven
```
sudo apt install maven
```