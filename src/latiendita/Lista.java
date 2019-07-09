package latiendita;

public class Lista {
    private Nodo cab;
    private Nodo ult;
    
    Lista()
    {
    }
    
    public boolean EsVacia()
    {
        return cab==null;
    }
    
    public void InsertarCab(Producto p)
    {
        if(EsVacia())
        {
            cab=new Nodo(p);
            ult=cab;
        }
        else
        {
            Nodo n = new Nodo(p, cab);
            cab.setAnt(n);
            cab=n;
        }
    }
    
    public void InsertarFinal(Producto p)
    {
        if(EsVacia())
            InsertarCab(p);
        else
        {
            Nodo n = new Nodo(p);
            n.setAnt(ult);
            ult.setSig(n);
            ult=n;
        }
    }
    
    public Producto EliminarCab()
    {
        Producto p=null;
        if(EsVacia())
            return p;
        else
        {
            p=cab.getDato();
            if(cab==ult)
            {
                
                cab=null;
                ult = null;
            }
            else
            {
                cab=cab.getSig();
                cab.setAnt(null);
            }
            return p;
        }
    }
    public Producto EliminarFinal()
    {
        Producto p=null;
        if(!EsVacia())
        {
            p=ult.getDato();
            if(cab==ult)
            {
                cab=null;
                ult=null;
            }
            else
            {
                ult=ult.getAnt();
                ult.setSig(null);
            }
        }
        return p;
    }
    
    public Producto Eliminar(int codigo)
    {
        Producto p = null;
        Nodo aux=cab;
        while (aux!=null && aux.getDato().getCodigo()!=codigo)
             aux = aux.getSig();
        
        if(aux!=null)
        {
             if(aux.getAnt()==null)
                 p=EliminarCab();
             else
             {
                 if(aux.getSig()==null)
                     p=EliminarFinal();
                 else
                 {
                     p=aux.getDato();
                     aux.getAnt().setSig(aux.getSig());
                     aux.getSig().setAnt(aux.getAnt());
                     aux=null;
                }
             }
    }
        return p;
}
    
    @Override
    public String toString()
    {
        String r="";
        Nodo aux=cab;
        while(aux!=null)
        {
            r=r+aux.getDato().toString() + "\n";
            aux=aux.getSig();
        }
        return r;
}
    public void Comprar(Producto p)
    {
        Nodo aux = cab;
        while(aux!=null && aux.getDato().getCodigo()!=p.getCodigo())
            aux=aux.getSig();
        
        if(aux==null)
            InsertarFinal(p);
        else
            aux.getDato().setCantidad(aux.getDato().getCantidad()+p.getCantidad());
    }
    
    public int Vender(int codigo, int cantidad)
    {
        int res;
        Nodo aux=cab;
        while(aux!=null && aux.getDato().getCodigo()!= codigo)
            aux=aux.getSig();
        
        if(aux==null)
            return 1;
        else
        {
            if(aux.getDato().getCantidad()<cantidad)
                return 2;
            else
            {
                aux.getDato().setCantidad(aux.getDato().getCantidad()-cantidad);
                return 3;
            }
        }
    }
    
    public Producto Buscar(int codigo)
    {
        Producto p = null;
        Nodo aux=cab;
        while (aux!=null && aux.getDato().getCodigo()!=codigo)
            aux=aux.getSig();
        
        if(aux!=null)
            p=aux.getDato();
        
        return p;
    }
    
    public void Incrementar (String seccion)
    {
        Nodo aux=cab;
        while(aux!=null)
        {
            if(aux.getDato().getSeccion().equalsIgnoreCase(seccion))
                aux.getDato().setPrecio(aux.getDato().getPrecio()*1.2);
            
            aux=aux.getSig();
        }
        
    }
    
    public Lista Escasos()
    {
        Nodo aux=cab;
        Lista esc = new Lista();
        while(aux!=null)
        {
            if(aux.getDato().getCantidad()<10)
                esc.InsertarFinal(aux.getDato());
            
            aux=aux.getSig();
        }
        return esc;
    }
            
}
