package gai.inter;

//接口一般不加载容器中，
//实际上时可以加的。加了spring也不创建对象
public interface Calculator {
    public int add(int i, int j);

    public int sub(int i, int j);

    public int mul(int i, int j);

    public int div(int i, int j);
}
