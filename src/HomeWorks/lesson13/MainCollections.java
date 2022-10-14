package HomeWorks.lesson13;

import java.util.*;

public class MainCollections {
    public static void main(String[] args) {

        // ArrayList, LinkedList
        // List: Iterable - Collection - List - AbstractList

        //  list.add("element"); 		//добавить элемент в список
        //  list.add(0, "2"); 			//добавить элемент в список по индексу
        //  list.set(0,"123"); 		    //заменить элемент по индексу
        //  list.get(0); 				//получить элемент по индексу
        //  list.size(); 				//узнать размер списка
        //  list.isEmpty(); 			//проверить пустоту списка
        //  list.contains("element"); 	//проверить наличием элемента в списке
        //  list.remove("23"); 		    //удалить конкретный элемент в списке
        //  list.clear(); 				//очистить список


        // Set: Iterable - Collection - Set - AbstractSet
        // HashSet, TreeSet, LinkedHashSet

        // set.add("1"); 			        	//Добавить элемент в наборе
        // set.contains("1"); 	        		//Проверить наличие элемента в наборе
        // set.isEmpty(); 			        	//Проверить пустоту набора
        // set.size(); 				        	//узнать размер набора
        // Iterator iterator = set.iterator(); 	//Создать итератор
        // iterator.hasNext(); 		        	//Проверить наличие следующего элемента
        // iterator.next();			        	//Достать следующий элемент
        // set.remove("2"); 	            	//Удалить элемент из набора
        // set.clear(); 			    		//Очистить набор

        // Map: AbstractMap
        // HashMap, TreeMap, HashTable

        // map.put("key", "value"); 	//Добавить связку ключ-значение
        // map.containsKey("key"); 		//Проверить наличие ключа
        // map.containsValue("key");	//Проверить наличие значения
        // map.isEmpty(); 				//Проверить пустоту набора
        // map.size(); 				    //узнать размер
        // map.keySet(); 				//Получить набор ключей
        // map.values(); 				//Получить коллекцию значений
        // map.get("key");				//Получить значение по ключу
        // map.remove("key"); 			//Удалить значение по ключу
        // map.clear(); 				//Очистить


        //===========================================

        ArrayList arrayList = new ArrayList();
        arrayList.add("First");
        arrayList.add("First");
        arrayList.add("First");
        arrayList.add("First");
        arrayList.add(0, "Third");
        arrayList.add(5, "MORE");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
////        arrayList.clear();
////        System.out.println(arrayList.equals(1));
//        System.out.println(arrayList.contains("First"));
//        System.out.println(arrayList.size());
//        System.out.println("wtf");
//        System.out.println(arrayList.get(5));
//        System.out.println(arrayList.hashCode());
//        System.out.println(arrayList.indexOf("MORE"));
//        System.out.println(arrayList.isEmpty());
//        System.out.println(arrayList.iterator());
//        System.out.println(arrayList.lastIndexOf("Third"));
//        System.out.println(arrayList.listIterator());
//        System.out.println(arrayList.remove(1));
////        System.out.println(arrayList.remove("First"));
//        System.out.println(arrayList.set(2, "Hi"));
//        System.out.println(arrayList.listIterator(2));
//
//
//        ArrayList linkedList = new ArrayList();
//        linkedList.add("First");
//        linkedList.add("First");
//        linkedList.add("First");
//        linkedList.add("First");
//        linkedList.add(0, "Third");
//        linkedList.add(5, "MORE");
////        arrayList.clear();
////        System.out.println(arrayList.equals(1));
//        System.out.println(linkedList.contains("First"));
//        System.out.println(linkedList.size());
//        System.out.println("wtf");
//        System.out.println(linkedList.get(5));
//        System.out.println(linkedList.hashCode());
//        System.out.println(linkedList.indexOf("MORE"));
//        System.out.println(linkedList.isEmpty());
//        System.out.println(linkedList.iterator());
//        System.out.println(linkedList.lastIndexOf("Third"));
//        System.out.println(linkedList.listIterator());
//        System.out.println(linkedList.remove(1));
////        System.out.println(arrayList.remove("First"));
//        System.out.println(linkedList.set(2, "Hi"));
//        System.out.println(linkedList.listIterator(2));
//
//        System.out.println(linkedList.toString());
//        System.out.println(arrayList.toString());
//
//
//

        System.out.println(arrayList.toString());
        TreeSet treeset = new TreeSet(arrayList);
        HashSet set = new HashSet<>(arrayList);
        ArrayList arrayListMore = new ArrayList();

        set.add("string");
        System.out.println(set.toString());

        HashMap hashMap = new HashMap();
//        hashMap.keySet();
//        hashMap.entrySet();

        hashMap.put("a","A");
        hashMap.put("b","B");
        hashMap.put("c","C");
        hashMap.put("d","D");
        hashMap.put(1,"A");
        hashMap.put(2,"B");
        hashMap.put(3,"C");
        hashMap.put(4,"D");


        System.out.println(hashMap.get("d"));
        System.out.println(hashMap.get("D")); // error
        System.out.println(hashMap.get("d"));
        System.out.println(hashMap.toString());
        System.out.println("hashMap.size(): " + hashMap.size());

        System.out.println("value of key 3: " + hashMap.get(3));
        System.out.println("keys: " + hashMap.keySet());
        System.out.println("values: " + hashMap.values());
        System.out.println("entrySet: " + hashMap.entrySet());


    }
}

