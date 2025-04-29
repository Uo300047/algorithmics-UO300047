Overall fine, some small issues:

* There is a proliferation of _a_, I guess for creating the folders, but they tarnish the presentation nonetheless.
* No heuristic applied at the greedy algorithm, so the result is less efficient. Could sort by those nodes with greater number of connections first, to reduce the number of colors used.
* Pruning could improve backtracking by not exploring branches which we calculate won't mathematically provide a result.
