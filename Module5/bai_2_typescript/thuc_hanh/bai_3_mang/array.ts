/**
 * Array
 */

// declare an array

const list: number[] = [1, 2, 3];

const categories: Array<string> =
    ['Sport', 'IT', 'Car'];

//-------------------------------------------------------------------------------

console.log('----- List -----');
list.forEach((num) =>
    console.log(num.toFixed(1))
);
// .toFixed(1): lấy sau dấu phẩy 1 chữ số (1.0)....

//--------------------------------------------------------------------------------

console.log('----- Categries -----');
categories.forEach((str) =>
    console.log(str.indexOf('a'))
);

//-----------------------------------------------------------------------------------

// convert mảng từ dạng này sang dạng khác.
console.log('------- Convert ---------');
const listSquare = list.map(num => num * num);
console.log(listSquare);
// Output: [1, 4, 9]

// lọc các phần tử thỏa mãn
console.log('------- Filter ---------');
const result = categories.filter(str => str.length > 2);
console.log(result);
// Output: ['Sport', 'Car']

//-----------------------------------------------------------------------------------
/**
 * Tuple
 */

// Declare a tuple type
let x: [string, number];
// Initialize it
x = ["hello", 10]; // OK
// Initialize it incorrectly
// x = [10, "hello"]; // Error

console.log(x[0].substr(1)); // OK
// console.log(x[1].substr(1));
// Error, Property 'substr' does not exist on type 'number'.

// @ts-ignore
x[3] = "world";
// OK, 'string' can be assigned to 'string | number'

// @ts-ignore
console.log(x[3].toString());

// @ts-ignore
x[5] = 100.25;

// @ts-ignore
console.log(x[5].toString());
// OK, 'string' and 'number' both have 'toString'
