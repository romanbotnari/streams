Download package info
``sudo apt-get update``

Upgrade system
``sudo apt-get upgrade``

Uninstall old installations
``sudo apt-get remove docker docker-engine docker.io containerd runc``

Set up the repository
``sudo apt-get install ca-certificates curl gnupg lsb-release``

Add docker gpg tools
``sudo mkdir -p /etc/apt/keyrings``

``curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg``

Set up docker repository
``echo "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null``

Install docker engine
``sudo apt-get update``

``sudo apt-get install docker-ce docker-ce-cli containerd.io docker-compose-plugin``

Start docker service
``sudo service docker start``
``sudo service docker status``

Add user to docker group if exists:
``sudo groupadd docker $USER``

Run docker example
``docker run hello-world``

