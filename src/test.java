
public class test {

	public static void main(String[] args) throws InterruptedException {
		LRU lru = new LRU(); //实例化LRU类
		System.out.println("开始生成随机数并插入");
		for (int i = 0; i < 10; i++) {
			int x = (int)(Math.random() * 1000); //产生0-1000的随机数
			lru.Add(x);
			System.out.println("当前表：" + lru.getMap());
			Thread.sleep(1000);
		}
		System.out.println("随机数插入完成");
		
	}

}
