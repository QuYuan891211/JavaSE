package Generic;


class PairTest {
	public static Pair<String> minmax(String[] a){
		if(a == null && a.length < 1){
			return null;
		}
		String min = a[0];
		String max = a[0];
		for(int i = 0; i< a.length;i++){
			if(min.compareTo(a[i])<0){
				min = a[i];
			}
			if(max.compareTo(a[i])>0){
				max = a[i];
			}
		}
		return new Pair(min,max);
	}
	
	public static void main(String[] a){
		String[] target = {"aaa","safg","sadasd"};
		Pair p = minmax(target);
		System.out.println(p.getFirstElement());
		System.out.println(p.getSecondElement());
	} 
}
