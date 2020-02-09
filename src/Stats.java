import java.util.*;
import java.util.concurrent.*;

public class Stats {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		Map<String,Ticker> statsMap = new ConcurrentHashMap<String,Ticker>();
		
		@Override
		public void putNewPrice(String symbol, double price) {
			Ticker ticker = null;
			if(statsMap.containsKey(symbol)) {
				ticker = statsMap.get(symbol);
				ticker.incrementCount();
				ticker.addPrice(price);
			}else {
				ticker = new Ticker(symbol,1,price);
			}
			statsMap.put(symbol,ticker);
		}

		@Override
		public double getAveragePrice(String symbol) {
			if (statsMap.containsKey(symbol)) {
				return statsMap.get(symbol).getAveragePrice();
			}
			return 0.0;
		}

		@Override
		public int getTickCount(String symbol) {
			if (statsMap.containsKey(symbol)) {
				return statsMap.get(symbol).getCount();
			}
			return 0;
		}
	}
	
	public static class Ticker{
		private String symbol ;
		private int count;
		private double price;
		
		public Ticker(String symbol, int count, double price) {
			super();
			this.symbol = symbol;
			this.count = count;
			this.price = price;
		}
		public String getSymbol() {
			return symbol;
		}
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public double getAveragePrice() {
			return price/count;
		}
		public void incrementCount() {
			this.count = count+1;
		}
		public void addPrice(double priceToBeAdded) {
			this.price = price+priceToBeAdded;
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(String.format("%s %.4f %d", symbol,
						stats.getAveragePrice(symbol),
						stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}