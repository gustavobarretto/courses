const { isTag } = require("domhandler")
const parser = require("../parser")

it("should give 4", () => {
  const result = parser.add(2, 2);
  expect(result).toBe(4);
})