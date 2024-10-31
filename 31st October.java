class Solution {
    public long minimumTotalDistance(List<Integer> robots, int[][] factories) {
        // Sort robots by their positions to align with factories
        Collections.sort(robots);
        Arrays.sort(factories, (a, b) -> Integer.compare(a[0], b[0]));

        int numRobots = robots.size();
        int numFactories = factories.length;

        // Initialize a DP table to store minimum distances
        long[][] minDist = new long[numRobots + 1][numFactories + 1];

        // Set distances for robots when no factories are left as maximum
        for (int i = 0; i < numRobots; i++) {
            minDist[i][numFactories] = Long.MAX_VALUE;
        }

        // Iterate through factories from the last to the first
        for (int factoryIndex = numFactories - 1; factoryIndex >= 0; factoryIndex--) {
            long cumulativeDist = 0;  // Holds cumulative distance for each factory
            Deque<Pair<Integer, Long>> deque = new ArrayDeque<>();
            deque.offer(new Pair<>(numRobots, 0L));  // Initialize deque with a sentinel value

            // Iterate through robots in reverse order
            for (int robotIndex = numRobots - 1; robotIndex >= 0; robotIndex--) {
                // Calculate cumulative distance from the robot to the current factory
                cumulativeDist += Math.abs(robots.get(robotIndex) - factories[factoryIndex][0]);

                // Remove robots from deque that are out of factory's capacity range
                while (!deque.isEmpty() && deque.peekFirst().getKey() > robotIndex + factories[factoryIndex][1]) {
                    deque.pollFirst();
                }

                // Maintain a monotonic deque by removing less optimal distances from the end
                while (!deque.isEmpty() && deque.peekLast().getValue() >= minDist[robotIndex][factoryIndex + 1] - cumulativeDist) {
                    deque.pollLast();
                }

                // Add the current robot's distance information to the deque
                deque.offerLast(new Pair<>(robotIndex, minDist[robotIndex][factoryIndex + 1] - cumulativeDist));

                // Set the minimum distance for this robot-factory pairing
                minDist[robotIndex][factoryIndex] = deque.peekFirst().getValue() + cumulativeDist;
            }
        }

        // Return the minimum total distance for all robots to reach any factory
        return minDist[0][0];
    }

    // Pair class to store robot index and minimum distance value for deque
    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
