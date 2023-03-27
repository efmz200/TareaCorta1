from flask import Flask
from mysql.connector import connect

connection = ''
cursor = ''
#API create
app = Flask(__name__)

#create conection
@app.route('/open') 
def open():
    global connection
    try:
        #database info
        connection = connect(
            host="localhost",
            user="user",
            password="password",
            database="test-db"
        )

        #conection
        cursor = connection.cursor()
        return 'coneccion creada'
    except:
        return 'error al crear la conexión'

#main route
@app.route('/')
def hello_world():
    return '¡Hola, mundo!'

#main route
@app.route('/create')
def create():
    try:
        # Sentencia SQL para crear la tabla persona
        create_table = '''
            CREATE TABLE IF NOT EXISTS persona (
                id INT AUTO_INCREMENT PRIMARY KEY,
                nombre VARCHAR(50) NOT NULL,
                apellido VARCHAR(50) NOT NULL,
                edad INT,
                email VARCHAR(100),
                direccion VARCHAR(100)
            )
        '''
        # Ejecutar la sentencia SQL
        cursor.execute(create_table)
        return 'Tabla creada'
    except:
        return 'Error al crear la tabla'

#close conection
@app.route('/close')
def close():
    try:
        # Cerrar la conexión
        cursor.close()
        cnx.close()
        return 'conexión cerrada'
    except:
        return 'error al cerrar la conexión'

#API start
def runn():
    app.run(port=8000)
runn()
