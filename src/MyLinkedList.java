import java.util.Iterator;

public class MyLinkedList<T> implements Iterable{
    private Node<T> head;
    private int count;
    private Node<T> tail;

    MyLinkedList()
    {
        head = null;
        count = 0;
        tail = null;
    }

    void addFirst(T nodeObject)
    {
        Node<T> node = new Node<>(nodeObject);
        node.next = head;
        head = node;
        count++;

        if(count == 1)
        {
            tail = head;
        }
    }

    T get(int index)
    {
        Node<T> current = head;
        int counter = 0;

        while(current != null)
        {
            if(counter == index)
                return current.data;
            counter++;
            current = current.next;
        }

        return  null;
    }

    int size()
    {
        return count;
    }

    @Override
    public String toString()
    {
        String ans = "";

        for(int i = 0; i < size(); i++)
        {
            if(i != size() - 1)
            {
                ans += get(i) + "\n";
            } else {
                ans += get(i);
            }
        }

        return ans;
    }

    public T removeFirst()
    {
        Node<T> test = head;

        head = head.next;
        count--;
        if(empty())
            tail = null;
        return test.data;

    }

    public void clear()
    {
        head = null;
        count = 0;
        tail = null;
    }

    public boolean empty()
    {
        return (size() == 0);
    }

    public void addLast(T data)
    {
        if(empty()){
            addFirst(data);
        } else {
            Node<T> newNode = new Node<>();
            newNode.data = data;
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
            count++;
        }
    }

    public void add(int index, T data) //part 7
    {
        //Addresses first and last additions
        if(index == 0) {
            addFirst(data);
        } else if(index == count) {
            addLast(data);
        } else {
            //transverses list and adds data
            Node<T> transverse = head;
            for(int i = 0; i < count; i++)
            {
                if((index - 1) == i)
                {
                    Node<T> newNode = new Node<>();
                    newNode.data = data;
                    newNode.next = transverse.next;
                    transverse.next = newNode;
                    count++;
                }
                transverse = transverse.next;
            }
        }
    }

    public T remove(int index) //part 7
    {
        if(index == 0)
            removeFirst();

        Node<T> removed = new Node<>();

        Node<T> transverse = head;
        for(int i = 0; i < count; i++)
        {
            if((index - 1) == i)
            {
                removed = transverse.next;
                transverse.next = (transverse.next).next;
                count--;
                if(index == count - 1)
                    tail = transverse.next;
            }
            transverse = transverse.next;
        }

        return removed.data;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class Node<T> {
        public T data;
        public Node<T> next;

        public Node()
        {
            data = null;
            next = null;
        }

        public Node(T data)
        {
            this.data = data;
            next = null;
        }

        @Override
        public String toString()
        {
            return data.toString();
        }
    }

    private class MyIterator implements Iterator<T>
    {
        private Node<T> current = head;
        private Node<T> currentRemove = head;
        int counter = 0;

        @Override
        public boolean hasNext() {
            if(current != null)
                return true;
            return false;
        }

        @Override
        public T next() {
            Node<T> temp = current;
            if(counter <= 1)
            {
                current = current.next;
            } else {
                current = current.next;
                currentRemove = currentRemove.next;
            }
            counter++;
            return temp.data;
        }

        @Override
        public void remove() {
            current = currentRemove.next.next;
            currentRemove.next = current;
            count--;
        }
    }

}


