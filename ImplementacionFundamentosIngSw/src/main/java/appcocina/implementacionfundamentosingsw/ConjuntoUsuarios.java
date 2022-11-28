package appcocina.implementacionfundamentosingsw;

import java.util.Iterator;

public class ConjuntoUsuarios implements Iterable<Usuario>{
  public Usuario[] conjuntoPersonas; // Atributo de la clase

  public ConjuntoUsuarios (Usuario [] p) { // Constructor de la clase
    conjuntoPersonas = p;   }

  public Iterator<Usuario> iterator() {
    Iterator<Usuario> it = new MiIteratorPersona();
    return it; }

  protected class MiIteratorPersona implements Iterator<Usuario>   {

    protected int posicionarray;
    public MiIteratorPersona()   { posicionarray = 0; }
    public boolean hasNext() {
      boolean result;
      if (posicionarray < conjuntoPersonas.length) { result = true; }
      else { result = false; }
      return result;
    }

    public Usuario next() {
      posicionarray++;
      return conjuntoPersonas[posicionarray-1];
    }

    public void remove(){
      throw new UnsupportedOperationException("No soportado.");
    }
  }
}
