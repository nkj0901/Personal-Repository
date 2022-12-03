function func(callFn) {
  callFn("hello");
}
function fn(msg) {
  console.log(msg);
}

// func(fn("hello"));
func(fn);
