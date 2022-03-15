const solution = (people, limit) => {
    people.sort(function(a, b){ return b-a; });
    let idx = people.length - 1;
    let count = 0;
    people.forEach((value,index) => {
       if(idx < index) {
           return;
       }
       if(value + people[idx] <= limit) {
           idx--;
       }
       count++;           
    });
    return count;
}