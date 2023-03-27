### **Base de Datos II (IC4302)** – Semestre 1, 2023
### **Tarea Corta #1** – Observability
### Jennifer Alvarado Brenes – 2020124171
### Luis Diego Delgado Muñoz – 2020030408
### Esteven Fernandez Hernandez – carnet
### Erick Madrigal Zavala – 2018146983
### David Suárez Acosta – 2020038304

## **Guía de instalación y uso de la tarea**

  
Antes de ejecutar cualquier comando se debe tener instalado en el equipo:
1. Docker desktop con kubernetes habilitado
2. Helm
3. Powershell
4. Lens

1.Desde línea de comandos, se ejecutan:
```sh
helm install monitoring monitoring --dependency-build
```  
2.Luego descargar todas las dependencias de las herramientas a utilizar
```sh
helm install monitoring monitoring --dry-run
```  
2.Actualizamos las dependencias:  
```sh
helm install database database --dependency-build
```  
3.Para instalar las bases de datos se ejecuta el siguiente comando:  
```sh
helm install database database --dry-run
```
## **Configuración de Grafana**
 
Una vez teniendo instaladas las bases de datos que se van a utilizar y las herramientas para monitorearlas, proseguimos con Grafana.

Para su funcionamiento, es necesario dirigirse  a la carpeta de grafana-config, y luego de esa a la de dashboards. Luego, en el archivo value.yaml se deben agregar en el "file:" para cada base, el nombre del archivo de su respectivo dashboard.

**Añadiendo los dashboard de las bases de datos**  
  
Para este paso vamos a buscar en internet "Grafana Dashboards" y visitaremos el primer sitio. En el buscador de dicho sitio, se va a proceder a buscar los dashboards respectivos a cada base de datos que se quiere monitorear.

Después de un proceso de selección, y posterior a haber realizado la descarga de cada dashboard, es necesario guardar estos archivos en una ruta específica.

Esta ruta corresponde a la carpeta donde se encuentre la tarea, siguiendo esta dirección: TareaCorta1 -> charts -> grafana-config -> dashboards.

Y en ese punto se guardan todos los archivos .json correspondientes a los dashboards. 

Posterior a esto, en los pods se busca Grafana, y se hace un post foward. Una vez que se despliegue la ventana correspondiente, se debe poner el check de abrir en el browser.

En este punto se solicitará un usuario y una contraseña. El usuario corresponde a "admin", y la contraseña se encuentra en secrets de Grafana.

Una vez después de ingresar, nos dirigimos a darshboards y monitoring, y aquí se podrán visualizar los dashboards añadidos. De esta forma se puede ingresar a los dashboards.


## **Configuración de las herramientas**  

**MariaDB**  

Añadimos el user y password para abrir y que funciones MariaDB y habilitamos el service monitor para las métricas.

[![maria-DBconfiguration.png](https://i.postimg.cc/SsFfgxVC/maria-DBconfiguration.png)](https://postimg.cc/7C9z6DFZ)
  
**MongoDB**  

Añadimos el user y password para abrir y que funciones MongoDB y habilitamos el service monitor para las métricas.

[![mongo-DBconfiguration.png](https://i.postimg.cc/mDYNJW6q/mongo-DBconfiguration.png)](https://postimg.cc/N90H2St7)
  
**Elasticsearch**  

Se deben de añadir nodos (minimo un nodo) en el area de master y se tiene que crear 3 replicas como minimo para que pueda funcionar Elasticsearch.
Habilitamos el service monitor para las métricas.

[![db3.png](https://i.postimg.cc/3wDZjvj3/db3.png)](https://postimg.cc/nsp7pMwW)
  
**PostgreSQL**  

Añadimos el user y password para abrir postgresql y habilitamos el service monitor para las métricas.

![N|Solid](https://i.pinimg.com/originals/64/e7/34/64e7341ee9bf014d6b53b067e614c6d2.jpg)
  
## **Pruebas de Gatling**


 
## **Conclusiones**  

Esta tarea fue de vital importancia para el aprendizaje y práctica de la utilización de herramientas como Docker Desktop, Kubernets, Lens, Helm, Grafana, Gatling, etc. 

Fue muy enriquecedor trabajar en la realización de la API hecha en Python con Flask, ya que es de conocimiento general que este tipo de aplicaciones intermediarias serán creadas y utilizadas durante el resto del curso y en los proyectos futuros.
  
## **Recomendaciones**  

* Es importante tener el "enable" en true de únicamente la base de datos que se va a monitorear, ya que si todas están activas al mismo tiempo, pueden consumir demasiados recursos del equipo.

* Es recomendable revisar que el proceso "Vmmem" asociado a Dockers tenga un consumo de memoria y procesador limitados, ya que en varios miembros del grupo representó una dificultad para poder utilizar el equipo, debido a un alto consumo en el CPU y la memoria. Para esto se encontró gran variedad de soluciones propuestas en la plataforma de YouTube.

## **Referencias**

YouTube. (2022). Gatling Beginner Tutorial 1 | Load Testing, Introduction, Download, Setup |. YouTube. Recuperado 24 de marzo, 2023, de https://www.youtube.com/watch?v=CPBWawzVeTo&amp;t=6s. 

Loewen, C. (2022, 12 agosto). Advanced settings configuration in WSL. Microsoft Learn. Recuperado 24 de marzo de 2023, de 
https://learn.microsoft.com/en-us/windows/wsl/wsl-config#configure-global-options-with-wslconfig

YouTube. (2022). Proceso Vmmem de Docker en Windows consume mucha RAM (SOLUCIÓN) |. YouTube. Recuperado 24 de marzo de 2023, de https://www.youtube.com/watch?v=CPBWawzVeTo&amp;t=6s. 
