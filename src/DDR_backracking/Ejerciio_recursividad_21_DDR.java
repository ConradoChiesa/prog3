package DDR_backracking;

public class Ejerciio_recursividad_21_DDR {

    public static void main(String[] args) {
        Elemento [] elementos = {
                new Elemento(1, 1),
                new Elemento(2, 2),
                new Elemento(4, 10),
                new Elemento(1, 2),
                new Elemento(12, 4)
        };

        Mochila m_base = new Mochila(15, elementos.length);
        Mochila m_opt = new Mochila(15, elementos.length);

        llenarMochila(m_base, elementos, false, m_opt);
        System.out.println(m_opt.toString());

    }

    public static void llenarMochila(Mochila m_base, Elemento[] elementos, boolean llena, Mochila m_opt) {
        if (llena) {
            if (m_base.getBeneficio() > m_opt.getBeneficio()) {
                Elemento[] elementosMochiBase = m_base.getElementos();
                m_opt.clear();
                for (Elemento e :
                        elementosMochiBase) {
                    if (e != null)
                    m_opt.addElemento(e);
                }
            }
        } else {
            for (int i = 0; i < elementos.length; i++) {
                if (!m_base.existeElemento(elementos[i])) {
                    if (m_base.getPesoMaximo() > m_base.getPeso() + elementos[i].getPeso()) {
                        m_base.addElemento(elementos[i]);
                        llenarMochila(m_base, elementos, false, m_opt);
                        m_base.eliminarElemento(elementos[i]);
                    } else {
                        llenarMochila(m_base, elementos, true, m_opt);
                    }
                }
            }
        }
    }
}
