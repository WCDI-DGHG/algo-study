const solution = n => {
    return n.toString().split("").map(v => parseInt(v)).reverse();
}