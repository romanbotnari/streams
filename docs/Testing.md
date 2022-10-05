```
nc -z localhost 9092
--------------------
Connection to localhost 9092 port [tcp/*] succeeded!
```

```
nc -z localhost 2181
--------------------

Connection to localhost 2181 port [tcp/*] succeeded!
```

```
curl -X POST localhost:8080/produce -H 'Content-Type: application/json' -d '[{"id":"123e-e89b-12d3-a456-4266","message":"this is a messavv3", "messageDate": "2017-01-13"}]'
--------------------------------------

*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8080 (#0)
> POST /produce HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.68.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 95
> 
* upload completely sent off: 95 out of 95 bytes
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
< Content-Length: 0
< Date: Wed, 05 Oct 2022 12:23:06 GMT
< 
* Connection #0 to host localhost left intact
```

```
docker logs kafka
-----------------

/usr/lib/python2.7/dist-packages/supervisor/options.py:296: UserWarning: Supervisord is running as root and it is searching for its configuration file in default locations (including its current working directory); you probably want to specify a "-c" argument specifying an absolute path to a configuration file for improved security.
  'Supervisord is running as root and it is searching '
2022-10-04 13:39:59,095 CRIT Supervisor running as root (no user in config file)
2022-10-04 13:39:59,095 WARN Included extra file "/etc/supervisor/conf.d/kafka.conf" during parsing
2022-10-04 13:39:59,095 WARN Included extra file "/etc/supervisor/conf.d/zookeeper.conf" during parsing
2022-10-04 13:39:59,102 INFO RPC interface 'supervisor' initialized
2022-10-04 13:39:59,102 CRIT Server 'unix_http_server' running without any HTTP authentication checking
2022-10-04 13:39:59,102 INFO supervisord started with pid 9
2022-10-04 13:40:00,106 INFO spawned: 'zookeeper' with pid 13
2022-10-04 13:40:00,111 INFO spawned: 'kafka' with pid 14
2022-10-04 13:40:01,115 INFO success: zookeeper entered RUNNING state, process has stayed up for > than 1 seconds (startsecs)
2022-10-04 13:40:01,115 INFO success: kafka entered RUNNING state, process has stayed up for > than 1 seconds (startsecs)
Created topic "my-kafka-topic".
```