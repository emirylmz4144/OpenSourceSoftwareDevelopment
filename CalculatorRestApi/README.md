### REST APİ İLE HESAP MAKİNESİ 

- Uygulamanın api testleri postman aracılığı ile yapılmıştır

- Ana url `http://localhost:3434/hesapmakinesi` olup toplama iki farklı endpoint ile 
çarpma ve toplama işlemleri yapılmaktadır 

- Aşağıda ise uygulamanın postman ile çalıştırılıp test edildiğine dair görselleri mevcuttur

#### GET İSTEĞİ POSTMAN İLE APİ TESTİ :

![img.png](Images/img.png)

#### POST İSTEĞİ POSTMAN İLE APİ TESTİ :

![img_1.png](Images%2Fimg_1.png)


### DEBİAN VE SERVİS PAKETİ OLUŞTURMA 

1.1. Servis paketi

WSL terminalini açın ve projenizin kök dizinine gidin

wsl de açılan işletim sistemi tabanı için terminale 

````properties
cd /mnt/c/Emirin\ Yazılım\ Şeysileri/OpenSourceSoftwareDevelopment/CalculatorRestApi
````

````properties
./mvnw clean package


````

Bu işlemlerden sonra ise dizin oluşturup

````properties
mkdir -p calculator
````

jar dosyasını dizine kopyalıyoruz
````properties
cp target/Calculator-0.0.1-SNAPSHOT.jar ./calculator/
````

ardından kök dizine dönüp bash'e yazıyoruz : 

````properties
nano calculator.service
````

servis dosyasını yapılandırıyoruz (servis dosyasının içine)

````properties
[Unit]
Description=Calculator REST API  
After=network.target  

[Service]
Restart=on-failure  
ExecStart=/usr/bin/java -jar /mnt/c/Emirin\ Yazılım\ Şeysileri/OpenSourceSoftwareDevelopment/CalculatorRestApi/calculator/Calculator-0.0.1-SNAPSHOT.jar  
User=emiryilmaz4144
Environment=SPRING_APPLICATION_JSON='{"spring.application.name":"Calculator","server.port":3434}'  
StandardOutput=journal  
StandardError=journal  

[Install]
WantedBy=multi-user.target
````

yazıyor ve servisi yüklemek için 

````properties
sudo mv calculator.service /etc/systemd/system/
````

dedikten sonra servisi başlatmak ve etkinleştirmek için 

````properties
sudo systemctl daemon-reload  
sudo systemctl start calculator  
sudo systemctl enable calculator
````

servis durumu kontrolü : 

````properties
sudo systemctl status calculator
````
1.1. Debian paketi

gereksinimleri yükleme
````properties
sudo apt-get install checkinstall
````

paketi oluşturma 

````properties
sudo checkinstall --pkgname=calculator --pkgversion="0.0.1" --backup=no --deldoc=no --install=no maven install:install
````
paketi kurma 

````properties
sudo dpkg -i calculator_0.0.1-1_amd64.deb
````

Sonuç olarak, yukarıdaki adımları 
tamamladıktan sonra projeniz calculator 
altında bulunacak ve systemd 
servisi olarak yönetilecektir. 
Ayrıca, .deb paketiniz ile başka 
sistemlere de dağıtım yapabilirsiniz.


