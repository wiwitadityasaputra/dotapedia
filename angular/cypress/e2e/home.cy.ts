describe('home page', () => {

  function toHomePage() {
    cy.visit('/home');
  }

  it('should open home page', () => {
    toHomePage();
    cy.contains('Defense');
    cy.contains('of the Ancients 2');
  })

  it('should have some next matches', () => {
    cy.get('.dp-next-match').should('have.length.greaterThan', 1);
  })

  it('should have 3 team', () => {
    cy.get('.dp-top-3-team').should('have.length', 3);
  })

  it('should have 3 player', () => {
    cy.get('.dp-popular-player').should('have.length', 3);
  })

  it('should have 6 hero', () => {
    cy.get('.dp-most-hero-pick').should('have.length', 6);
  })

  it('should have 3 news', () => {
    cy.get('.dp-latest-news').should('have.length', 2);
  })

  it('should goto team page', () => {
    toHomePage();
    cy.get('.dp-next-match-team-logo img').first().click();
    cy.url().should('include', '/team');

    toHomePage();
    cy.get('.dp-top-3-team img').first().click();
    cy.url().should('include', '/team');
  })

  it('should goto tournament page', () => {
    toHomePage();
    cy.get('.dp-tournament-image-wrapper-prev-match img').first().click();
    cy.url().should('include', '/tournament');
  })

  it('should goto tournament page', () => {
    toHomePage();
    cy.get('.dp-most-popular-player img').first().click();
    cy.url().should('include', '/player');
  })
})