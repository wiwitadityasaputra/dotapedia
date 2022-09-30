let config = require('../support/config');

describe('home page', () => {
  it('should open home page', () => {
    cy.visit(config.env.MAIN_URL + '/tournament');
    cy.contains('DoTa2');
    cy.contains('Tournaments');
  })
})