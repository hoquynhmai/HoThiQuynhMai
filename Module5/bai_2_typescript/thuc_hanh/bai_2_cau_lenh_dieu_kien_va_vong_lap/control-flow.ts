/**
 * If/else
 */

let count = 50;
if (count > 0) {
    count--;
} else {
    count = 0;
}
console.log(count);

/**
 * loop
 */

console.log("------- For Loop --------");

const keys = ['a','b','c','d','e','f'];
for (let idx = 0; idx < keys.length; ++idx) {
    console.log(keys[idx]);
}

console.log("------- While Loop -------");
let idx = 0;
while (idx < keys.length) {
    console.log(keys[idx]);
    ++idx;
}

console.log("------- Do-while Loop -------");

idx = 0;
do {
    console.log(keys[idx]);
    ++idx;
} while (idx < keys.length);

console.log("------- For-Of Loop -------");
for (const item of keys) {
    console.log(item);
}

console.log("-------- For-in Loop -------");
const user = {
    name: 'Bob',
    age: 55
};
for (const key in user) {
    console.log(`${key}: ${user[key]}`);
}
