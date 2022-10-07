# /bin/bash
echo $1
RANGE=$1
tss=$(date +"%s")
result_file=`date +%Y-%m-%d_%H_%M_%S`
echo "Test range: $RANGE" > "testing/results/out$result_file"
echo "Start of test: $tss" >> "testing/results/out$result_file"

for ((i=1; i<=$RANGE; i++))
do 
    curl -X POST localhost:8080/produce -H 'Content-Type: application/json' -d '[{"id":"123e-e89b-12d3-a456-4266","message":"this is the $i message", "messageDate": "2017-01-13"}]'
done

tse=$(date +"%s")
echo "End of test: $tse" >> "testing/results/out$result_file"
duration=$(($tse-$tss))
echo "Duration: $duration" >> "testing/results/out$result_file"
