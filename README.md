#Reddy Prueba

### Arquitectura MVVM

El modelo
Representa la capa de datos y/o la lógica de negocio, también denominado como el objeto del dominio. El modelo contiene la información, pero nunca las acciones o servicios que la manipulan. En ningún caso tiene dependencia alguna con la vista.

#### *Paquete data

  * Paquete model.post:  Contiene los data class que representan la los objetos mapeados en el api de consumo
    * Clase: Post.kt

  * Clase:PostDataSet.kt 
    *Es la encargada de realizar el consumo de los servicios api, es la unica clase que tiene ejecuta los servicios de post de la app

#### *Paquete domain.post

  * Paquete model.post:  Contiene la interfaz de dominio e implementacion para el consumo y entrega de datos de la aplicacion
    * Clase:RepoPost.kt
        * Interfaz encargada de definir los metodos de logica de negocio ò casos de uso que ejecutara la app
    * Clase:RepoPostImpl.kt
        * Clase encargada de implementar los metodos o casos de uso definidos en la interfaz y el la unica clase que se cominica con el dataset
    * Clase:ServicesPost.kt
        * interfaz que contiene los servicios que se ejecutan dentro de la aplicacion

La vista
La misión de la vista es representar la información a través de los elementos visuales que la componen. Las vistas en MVVM son activas, contienen comportamientos, eventos y enlaces a datos que, en cierta manera, necesitan tener conocimiento del modelo subyacente.

#### *Paquete principal ui
  Contiene las vistas utilizadas en la aplicacion
  * Paquete adapter
  Contienen los adaptadores de las vistas de PostActivity,PremiosActivity
    * Clases: PostAdapter,PremiosAdapter
* Clases : PostActivity.kt,DetallePostActivity.kt,PremiosActivity.kt

Modelo de vista
El modelo de vista es un actor intermediario entre el modelo y la vista, contiene toda la lógica de presentación y se comporta como una abstracción de la interfaz. La comunicación entre la vista y el viewmodel se realiza por medio los enlaces de datos.

#### *Paquete principal vewmodel
  Contiene los viewmodel de la app
  * Paquete post

    * Clases: PostViewModel.kt, VMPostFactory.kt


#### ¿En qué consiste el principio de responsabilidad única? Cuál es su propósito?

Principios del diseño orientado a objetos; Principios SOLID; [SRP] Principio de responsabilidad única
"Cada objeto en el sistema deben tener una simple responsabilidad, y todos los servicios de los objetos deben cumplir con esa simple responsabilidad"

Su objetivo es hacer que las clases sean mas suceptibles al cambio y que podamos tener un mejor control para refactorizar y escalar nuestra aplicacion ya que si una clase tiene mas de una responzabilidad es man dificil su sostenibilidad. 


#### Imajenes de muestra app

![Texto alternativo](1.jpeg)
![Texto alternativo](2.jpeg)
![Texto alternativo](3.jpeg)
![Texto alternativo](5.jpeg)
![Texto alternativo](4.jpeg)
