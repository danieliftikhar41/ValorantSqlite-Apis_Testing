package com.example.logginvalorant.Controllers;

import com.example.logginvalorant.Moduls.Agent;
import com.example.logginvalorant.Moduls.Map;
import com.example.logginvalorant.Moduls.Weapon;

public interface SelectListner {

  void onItemClicked(Agent agent);
  void onItemClicked(Map map);
  void onItemClicked(Weapon weapon);
}
