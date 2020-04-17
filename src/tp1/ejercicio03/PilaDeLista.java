package tp1.ejercicio03;
/*Federico Casanova 21:01
Una última cosita ya que van a tener varios días para trabajar en sus casas.
En el ej3 por ejemplo, es muy interesante que piensen cómo van a implementar cada método de la pila usando la lista. Y que lo piensen y tomen la decisión en
función de la complejidad computacional que va a resultar, intentando quedarme siempre con la opción en que me quede menor complejidad big O.
Entonces por ejemplo si decido que mi tope de pila se agregue siempre al final de la lista, cuánto va a quedar la
de cada método (pop, push, top)??, y en cambio si el elemento que agrego al tope de la pila lo pongo siempre al pincipio de mi lista, cómo impacta eso ahora
en la complejidad que me va a quedar en cada método ???
COn las dos opciones voy a obtener una pila funcional, o sea cada método va a hacer y a responder como se espera. El tema es cuánto queda la complejidad ?
En función de eso se que una opción u otra de implementación de la pila va a tardar más o menos, y sobre todo si pongo muuuuchos el
elementos donde ya la diferencia de tiempos de ejecución de una opción y de la otra empiece a hacerse evidente paraa el usuario.
O sea, usen la info que les da saber la complejidad computacional big O para justamente tomar la decisión.
Esto es válido para cualquier ejercicio y en general para diseñar una implementación para cualquier cosa que les pidan, es un parámetro de calidad de la
implementación que hagan.
*/
import tp1.ejercicio1.MySimpleLikedList;

import java.util.Iterator;

public class PilaDeLista {
    private MySimpleLikedList pila;

    public PilaDeLista() {
        this.pila = new MySimpleLikedList();
    }
    public void push(Integer o) {
        pila.insertFront(o);
    }

    public Integer pop() {
//        return this.pila.extractFront();
        return null;
    }

    public Object top() {
        return this.pila.get(0);
    }
//metodo a medio implementar
    public void reverse() {
        Integer auxArr[];
        auxArr = new Integer[pila.size()];
        int pos = 0;
        while (this.pila.size()>0) {
           auxArr[pos] = pop();
           pos++;
        }
        for (int i = auxArr.length-1; i >= 0; i--) {
            this.push(auxArr[i]);
        }

    }
}
