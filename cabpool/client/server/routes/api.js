const express = require('express');
const router = express.Router();

/* GET api listing. */
router.get('/', (req, res) => {
  res.send('api works');
});

router.get('/msg', (req, res) => {
  res.send('hello');
});

module.exports = router;