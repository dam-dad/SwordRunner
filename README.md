**Índice:**- 

**-Descripción del proyecto**

##### -Guia de uso

**-Problemas encontrados**



**Descripción**

SwordRunner es un juego de plataformas, el cual se compone de un mapa con varios obstáculos con las que tu personaje puede colisionar siendo el objetivo del juego conseguir llegar al límite del mapa y pasar a través de la puerta final.



**Guía de uso**

Al iniciar el juego te saldrá una ventana con un botón al que debes darle para que te aparece en la misma ventana el menú, donde verás dos opciones. La primera opción sería la pantalla que te muestra un poco los controles, que en resumidas cuentas es utilizar el WASD para poder moverte por el mundo siendo la W un salto del personaje, y el cómo se juega. Por otro lado, la segunda opción del menú sería la que te muestra los controles del juego y tiene un botón llamado “Listo”, el cual iniciará el juego. Por último, cuando estés jugando se cargará tu personaje y un mapa en el que podrás moverte y tu objetivo es llegar a la meta que es una puerta al final del mapa la cual te enseñará una ventana que te dice que has terminado el juego y que al cerrarla se cerrará este mismo.



**Problemas encontrados**

Nuestro problema principal fue el hecho de que el lenguaje de marcado de interfaz de usuario FXGL está bastante obsoleto o tiene documentación de versiones muy anteriores, y dicha documentación es muy escasa o difícil de encontrar. A raíz de este problema surgieron los siguientes: la función de initGame(), la cual sólo se ejecuta una vez, hace que si hay algún condicional o haya algún cambio en dicha función no la vuelve  a ejecutar, obligándolos así a hacer el código de una forma diferente a lo que podríamos usar en otras librerías de desarrollo de juegos.;otro problema fue que, al finalizar la partida y llega a la meta, no podíamos hacer que se cambiara la escena del juego por la del menú de nuevo y este simplemente cerraba el programa completamente.;la redimensión de la stage principal al abrir el juego, ya que el tamaño de la ventana tenía que especificarse en la función initSettings(), no pudiendo así cambiar el tamaño de dicha Stage en el onClick() que inicializa el juego.