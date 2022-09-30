describe('home page', () => {
  it('should open home page', () => {
    cy.visit('/tournament');
    cy.contains('DoTa2');
    cy.contains('Tournaments');
  })
})