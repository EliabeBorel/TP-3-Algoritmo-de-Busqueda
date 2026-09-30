Hola. 30/09/2026 version final.

---
### 📚 Informe Final
El trabajo práctico cuenta con un informe detallado sobre el análisis de complejidad y los resultados obtenidos.

**Opciones de visualización:**
1. 📖 Leer el archivo local: [ [Documento final TP 3 LB.pdf](https://github.com/user-attachments/files/32841894/Documento.final.TP.3.LB.pdf) ]
2. ☁️ [Abrir en Google Docs](https://docs.google.com/document/d/1Y7YFE4vEzDGyFifgRao1Ttdp5xSWfSbGcIXlQyixnyQ/edit?tab=t.b2lxd98eef13#heading=h.4cbvatv47xev) (Lectura rápida en el navegador)

---

La carpeta `tp3` contiene todo lo necesario para la ejecución limpia del código. Solo necesitas clonar el repositorio y correr la clase principal. Aquí tienes los pasos:


### 🚀 Cómo probar el proyecto:

**1. Clonar el repositorio**

Abre tu terminal y ejecuta el siguiente comando:
```bash
git clone https://github.com/EliabeBorel/TP-3-Algoritmo-de-Busqueda.git
```
**2. Abrir en tu IDE**

Importa el proyecto en tu entorno de desarrollo favorito (Eclipse, IntelliJ IDEA, VS Code, etc.).

**3. Ejecutar el código**

Localiza el archivo Main.java dentro del paquete tp3 y ejecútalo. El programa generará automáticamente la lista de sospechosos, realizará el pre-calentamiento de la JVM y mostrará en consola las métricas de tiempo comparando la Búsqueda Lineal vs. Búsqueda Binaria. No se requieren dependencias externas.

**De otra manera puede solamente descargar este archivo comprimido listo para compilar:**

[ [tp3.zip](https://github.com/user-attachments/files/32842749/tp3.zip) ]

---
```markdown
### 📊 Resultados de Rendimiento (Benchmark)
Al realizar la prueba de estrés con una lista de **10.000.000 de sospechosos**, obtuvimos los siguientes tiempos (promediados para evitar el ruido de la JVM), demostrando la enorme eficiencia de la búsqueda binaria:

| Cantidad | Caso a buscar | Búsqueda Lineal | Búsqueda Binaria |
| :--- | :--- | :--- | :--- |
| 10.000.000 | Inicio de la lista | 0 ms | 48 ns |
| 10.000.000 | Medio de la lista | 60 ms | **23 ns** |
| 10.000.000 | Final de la lista | 128 ms | 44 ns |

