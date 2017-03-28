
./kcadm.sh config credentials --server http://localhost:8080/auth --realm master --user admin

./kcadm.sh get realms/nemesis

./kcadm.sh get users -r nemesis --offset 0 --limit 1000

