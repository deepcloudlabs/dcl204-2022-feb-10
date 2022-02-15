package com.example;

public class ProgrammingLanguage {
	private Language language;
	private int level;
	private int experience;

	public ProgrammingLanguage(Language language, int level, int experience) {
		this.language = language;
		this.level = level;
		this.experience = experience;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "ProgrammingLanguage [language=" + language + ", level=" + level + ", experience=" + experience + "]";
	}

}
