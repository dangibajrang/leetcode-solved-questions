class Solution {
  public long dividePlayers(int[] skill) {
    final int n = skill.length;
    
    // Calculate the target team skill by dividing the total skill sum by the number of teams
    final int teamSkill = Arrays.stream(skill).sum() / (n / 2);
    long ans = 0; // To store the total chemistry of all teams
    Map<Integer, Integer> count = new HashMap<>(); // Map to count the occurrences of each skill

    // Count the frequency of each skill level
    for (final int s : skill)
      count.merge(s, 1, Integer::sum); // Increase the count of skill `s` in the map

    // Loop through the map and form valid teams
    for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
      final int s = entry.getKey(); // Current skill
      final int freq = entry.getValue(); // Frequency of the current skill
      final int requiredSkill = teamSkill - s; // The skill needed to form a valid team

      // If the required skill's frequency doesn't match, return -1 (not possible to form valid teams)
      if (count.getOrDefault(requiredSkill, 0) != freq)
        return -1;

      // Calculate the chemistry of the current skill pair and add it to the total chemistry
      ans += (long) s * requiredSkill * freq;
    }

    // Divide the total chemistry by 2 since we counted each pair twice
    return ans / 2;
  }
}
