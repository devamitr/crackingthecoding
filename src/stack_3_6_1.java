import java.util.LinkedList;
 // v v important
public class stack_3_6_1 {
    // this is the ctci implmentation
    abstract class Animal{
        private int order;
        public String name;
        public Animal(String s){this.name =s;}
        public void setOrder(int odr){this.order=odr;}
        public int getOrder(){return order;}
    }

    public class Dog extends Animal{
        public Dog(String s){super(s);}
    }

    public class Cat extends Animal{
        public Cat(String s){super(s);}
    }

    public class AnimalQueue{
        LinkedList<Dog> dog_q = new LinkedList<Dog>();
        LinkedList<Cat> cat_q = new LinkedList<Cat>();
        private int order=0;
        public void enqueue(Animal a){
            a.setOrder(order);
            order++;

            if(a instanceof Dog){dog_q.addLast((Dog)a);}
            else{cat_q.addLast((Cat)a);}
        }

        public Cat dequeueCat(){
            return cat_q.poll();
        }

        public Dog dequqeueDog(){
            return dog_q.poll();
        }

        public Animal dequeueAny(){
            if(dog_q.size()==0){
                return dequeueCat();
            }
            else if(cat_q.size()==0){
                return dequqeueDog();
            }
            else{
                Dog dg = dog_q.peek();
                Cat ct = cat_q.peek();
                if(dg.getOrder()<ct.getOrder()){
                    return dequqeueDog();
                }
                else{
                    return dequeueCat();
                }
            }
        }
    }
}
