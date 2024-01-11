cd ${{ secrets.TARGET_DIRECTORY }}
sudo echo "${{ secrets.DB_ENV }}" > db.env
sudo echo "${{ secrets.BACKEND_SECRET_ENV }}" > backend-secret.env
sudo echo "${{ secrets.SPRING_SOURCE }}" > spring-source.env
sudo docker-compose -f docker-compose.ec2.yml down
sudo echo "y" | docker volume prune -a
sudo docker-compose -f docker-compose.ec2.yml pull
sudo docker-compose -f docker-compose.ec2.yml up -d