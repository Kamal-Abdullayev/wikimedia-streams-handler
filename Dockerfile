FROM confluentinc/cp-kafka-connect-base:7.8.0

RUN confluent connect plugin install --force hpgrahsl/kafka-connect-mongodb:1.1.0 \
   && confluent connect plugin install --force microsoft/kafka-connect-iothub:0.6 \
   && confluent connect plugin install --force wepay/kafka-connect-bigquery:1.1.0 \
   || { echo "Plugin installation failed"; exit 1; }
